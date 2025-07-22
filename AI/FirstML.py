# we have to create a new program to run linear regression ML and test it train it and run it.

import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score
# Generate some synthetic data
np.random.seed(0)
X = np.random.rand(100, 1)
y = 3 * X.squeeze() + np.random.randn(100) * 0.1  # Linear relation with noise
# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
# Create a linear regression model
model = LinearRegression()
# Train the model
model.fit(X_train, y_train)
# Make predictions
y_pred = model.predict(X_test)
# Evaluate the model
mse = mean_squared_error(y_test, y_pred)
print("Mean Squared Error: ", mse)
r2 = r2_score(y_test, y_pred)
print("R^2 Score: ", r2)
# Print the coefficients
print("Coefficients: ", model.coef_)
print("Intercept: ", model.intercept_)
# Save the model for future use