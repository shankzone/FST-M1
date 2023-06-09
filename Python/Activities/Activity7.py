numbers = list(input("Enter a sequence of comma separated values: ").split(","))
sum = 0

for number in numbers:
  sum = sum + int(number)

print(sum)