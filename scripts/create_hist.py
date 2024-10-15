"""
This module reads the data insigts from the q{x}.csv and creating bar chars for it
"""

import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV file
CSV_FILE = 'output/q1.csv'
df = pd.read_csv(CSV_FILE)

# Extract the column names
columns = df.columns

# Plot histogram
plt.figure(figsize=(10, 6))
plt.bar(df[columns[0]], df[columns[1]], color='blue', edgecolor='black')
plt.title('Average price per meter squared depending on the renovation type')
plt.xlabel(columns[0])
plt.ylabel(columns[1])

# Save the plot to jpg
OUTPUT_JPG = 'output/q1.jpg'
plt.savefig(OUTPUT_JPG)
plt.close()

print("Histogram saved to output/q1.jpg.")

# Read the CSV file
CSV_FILE = 'output/q2.csv'
df = pd.read_csv(CSV_FILE)

# Extract the column names
columns = df.columns

# Convert distance in degrees to kilometers
df['distance_in_km'] = df[
        columns[0]
    ].apply(
        lambda x: round(float(x.split(' - ')[1]) / 0.3236 * 25.9, 2)
        )

# Plot histogram
plt.figure(figsize=(10, 6))
plt.bar(df['distance_in_km'], df[columns[1]], color='green', edgecolor='black')
plt.title('Average price per meter squared by Distance in km from the ceneter of the city')
plt.xlabel('Distance in Kilometers')
plt.ylabel(columns[1])

# Save the plot to jpg
OUTPUT_JPG = 'output/q2.jpg'
plt.savefig(OUTPUT_JPG)
plt.close()

print("Histogram saved to output/q2.jpg.")


# Read the CSV file
CSV_FILE = 'output/q3.csv'
df = pd.read_csv(CSV_FILE)

# Extract the column names
columns = df.columns

# Convert distance_to_metro to numeric values for sorting
df['distance_to_metro_numeric'] = df[columns[0]].apply(lambda x: float(x.split('-')[0]))

# Sort the DataFrame by the numeric distance_to_metro
df_sorted = df.sort_values(by='distance_to_metro_numeric')

# Plot histogram
plt.figure(figsize=(10, 6))
plt.bar(df_sorted[columns[0]], df_sorted[columns[1]], color='orange', edgecolor='black')
plt.title('Average cost of the meter squared by Distance to Metro Station (Minutes)')
plt.xlabel('Distance to Metro Station (Minutes)')
plt.ylabel(columns[1])

# Save the plot to jpg
OUTPUT_JPG = 'output/q3.jpg'
plt.savefig(OUTPUT_JPG)
plt.close()

print("Histogram saved to output/q3.jpg.")


# Read the CSV file
CSV_FILE = 'output/q4.csv'
df = pd.read_csv(CSV_FILE)

# Extract the column names
columns = df.columns

# Plot histogram
plt.figure(figsize=(10, 6))
plt.bar(df[columns[0]], df[columns[1]], color='purple', edgecolor='black')
plt.title('Number of apparments presented on the market by floor number')
plt.xlabel('Apartment Floor')
plt.ylabel('Count')

# Save the plot to jpg
OUTPUT_JPG = 'output/q4.jpg'
plt.savefig(OUTPUT_JPG)
plt.close()

print("Histogram saved to output/q4.jpg.")


# Path to the CSV file
FILE_PATH = "output/q5.csv"

# Read the data from the CSV file using pandas
df = pd.read_csv(FILE_PATH)

# Extract the columns
x_labels = df['q5_results.apartment_relative_to_building_height']
y_values = df['q5_results.mean_m2_price']

# Create the histogram
plt.bar(x_labels, y_values, color='blue')

# Rotate x-axis labels by 90 degrees
plt.xticks(rotation=90)

# Add labels and title
plt.xlabel('Apartment Relative to Building Height')
plt.ylabel('Mean m2 Price')
plt.title('Histogram of Mean m2 Price by Apartment Relative to Building Height')

# Save the histogram to a file
OUTPUT_FILE_PATH = "output/q5.jpg"
plt.savefig(OUTPUT_FILE_PATH, bbox_inches='tight')

# Close the plot to free up memory
plt.close()

print("Histogram saved to output/q5.jpg.")
