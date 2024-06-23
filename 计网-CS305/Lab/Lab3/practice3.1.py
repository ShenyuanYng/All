import os
import magic
mime = magic.Magic(mime=True)

def print_suffix(path):
    for root, dirs, files in os.walk(path):
        for file in files:
            suffix = mime.from_file((root + "\\" + file))
            print(root + "\\" + file + " -> " +suffix)
        
        for dir in dirs:
            print_suffix(dir)
        
if __name__ == "__main__":
    print_suffix("./")