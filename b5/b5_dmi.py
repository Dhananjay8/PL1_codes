import sys,os

os.system("dmidecode -t")
string1=raw_input("which info you want:")
os.system("dmidecode -t" +string1)
