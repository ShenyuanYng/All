if __name__ == '__main__':
    digit = int(input("How many digits do you want to generate?"))
    number = 2023
    for i in range(digit):
        last = number % 10
        last_but_one = int(number/10) % 10
        number = number * 10 + (last * last_but_one) % 10
    
    print("The last digit is " + str(number % 10))