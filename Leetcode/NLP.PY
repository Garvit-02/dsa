import numpy as np
from datasets import load_dataset
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.svm import LinearSVC
from sklearn.metrics import accuracy_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Embedding, LSTM, Dense
from tensorflow.keras.preprocessing.sequence import pad_sequences
from tensorflow.keras.preprocessing.text import Tokenizer
from transformers import BertTokenizer, BertForSequenceClassification
from transformers import Trainer, TrainingArguments
from transformers import pipeline
import torch

# Load IMDb dataset
dataset = load_dataset("imdb")
train_texts = dataset["train"]["text"][:5000]
train_labels = dataset["train"]["label"][:5000]
test_texts = dataset["test"]["text"][:1000]
test_labels = dataset["test"]["label"][:1000]

results = {}

# 1. Naive Bayes
vectorizer = TfidfVectorizer(max_features=5000)
X_train = vectorizer.fit_transform(train_texts)
X_test = vectorizer.transform(test_texts)
nb_model = MultinomialNB()
nb_model.fit(X_train, train_labels)
nb_preds = nb_model.predict(X_test)
results["Naive Bayes"] = round(accuracy_score(test_labels, nb_preds) * 100, 2)

# 2. SVM
svm_model = LinearSVC()
svm_model.fit(X_train, train_labels)
svm_preds = svm_model.predict(X_test)
results["SVM"] = round(accuracy_score(test_labels, svm_preds) * 100, 2)

# 3. LSTM (Keras)
tokenizer = Tokenizer(num_words=10000)
tokenizer.fit_on_texts(train_texts)
X_train_seq = tokenizer.texts_to_sequences(train_texts)
X_test_seq = tokenizer.texts_to_sequences(test_texts)
X_train_pad = pad_sequences(X_train_seq, maxlen=200)
X_test_pad = pad_sequences(X_test_seq, maxlen=200)

lstm_model = Sequential()
lstm_model.add(Embedding(input_dim=10000, output_dim=128, input_length=200))
lstm_model.add(LSTM(64))
lstm_model.add(Dense(1, activation='sigmoid'))
lstm_model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
lstm_model.fit(X_train_pad, np.array(train_labels), epochs=2, batch_size=64, verbose=0)
lstm_acc = lstm_model.evaluate(X_test_pad, np.array(test_labels), verbose=0)[1]
results["LSTM"] = round(lstm_acc * 100, 2)

# 4. BERT (pipeline for speed)
bert_classifier = pipeline("sentiment-analysis", model="distilbert-base-uncased-finetuned-sst-2-english")
bert_preds = []
batch_size = 32  # Process in batches to avoid memory issues
for i in range(0, len(test_texts), batch_size):
    batch = test_texts[i:i + batch_size]
    batch_preds = [1 if result['label'] == "POSITIVE" else 0 for result in bert_classifier(batch)]
    bert_preds.extend(batch_preds)
results["BERT"] = round(accuracy_score(test_labels, bert_preds) * 100, 2)

# Output final comparison
print("Model        | Accuracy")
print("-------------|---------")
for model, acc in results.items():
    print(f"{model:<13}| {acc}%")
