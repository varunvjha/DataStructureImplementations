


You are asked to ensure that the first and last names of people begin with a capital letter in their passports.

def solve(s):
    for x in s[:].split():
        s = s.replace(x, x.capitalize())
    return s       


