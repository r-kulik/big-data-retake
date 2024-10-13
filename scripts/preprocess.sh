#!/bin/bash

# Define the URL and file names
DATASET_URL="https://www.kaggle.com/api/v1/datasets/download/egorkainov/moscow-housing-price-dataset"
ZIP_FILE="moscow-housing-price-dataset.zip"
DATA_DIR="data"
GEO_FILE_URL="https://drive.google.com/uc?export=download&id=1K19Pv59G4qs5hfZUZmuRbp9Qfo1E5N0M"
GEO_FILE="dataGeo.csv"

# Function to print beautiful messages
print_message() {
    local message=$1
    local color=$2   
    local symbol=$3
    local reset="\033[0m"

    case $color in
        "green") color_code="\033[32m";;
        "blue") color_code="\033[34m";;
        "red") color_code="\033[31m";;
        "yellow") color_code="\033[33m";;
        *) color_code="\033[0m";;
    esac

    echo -e "${color_code}${symbol} ${message}${reset}"
}

# Print loading message
print_message "Data is loading..." "blue" ">>"

# Check if the data directory exists, if not, create it
if [ ! -d "$DATA_DIR" ]; then
    mkdir -p "$DATA_DIR"
fi

# Download the dataset
if [ ! -f "$ZIP_FILE" ]; then
    wget "$DATASET_URL" -O "$ZIP_FILE"
    if [ $? -ne 0 ]; then
        print_message "Failed to download the dataset." "red" "!!"
        exit 1
    fi
fi

# Print loaded message
print_message "Data has been loaded." "green" ">>"

# Unzip the dataset
unzip -o "$ZIP_FILE" -d "$DATA_DIR"
if [ $? -ne 0 ]; then
    print_message "Failed to unzip the dataset." "red" "!!"
    exit 1
fi

# Print unzip success message
print_message "Data unzip was successful." "green" ">>"

# Delete the zip file
rm -f "$ZIP_FILE"

# Print deletion message
print_message "Zip file with data is deleted." "yellow" ">>"

# Download the dataGeo.csv file without checking certificates
print_message "Downloading dataGeo.csv..." "blue" ">>"
wget --no-check-certificate "$GEO_FILE_URL" -O "$DATA_DIR/$GEO_FILE"
if [ $? -ne 0 ]; then
    print_message "Failed to download dataGeo.csv." "red" "!!"
    exit 1
fi

# Print download success message
print_message "dataGeo.csv has been downloaded." "green" ">>"

print_message "All operations completed successfully." "green" ">>"