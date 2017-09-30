import os

print (os.system("adb devices"))
print "Product Name:-"
x="adb shell"
y="getprop ro.productname.name"
print os.system(x+" "+y)

print "SDK Version:-"
a="adb shell"
b="getprop ro.build.version.release"
print os.system(a+" "+b)

print "OS Name:-"
c="adb shell"
d="getprop ro.com.google.clientidbase"
print os.system(c+" "+d)

