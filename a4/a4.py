import os,sys,datetime
print 'Enter name of the file:'
name=raw_input()
fd=os.open(name,os.O_RDWR)
info=os.fstat(fd)
print "File Information :"
print "File Inode no:",info.st_ino
print "Device number:",info.st_dev
print "Number of link:",info.st_nlink
print "UID of the file:%d" %info.st_uid
print "Size:",info.st_size
print "Access time:",info.st_atime
print "Modify time:",info.st_mtime
print "Change time:",info.st_ctime
print "Protection:",info.st_mode
print "Number of blocks allocated:",info.st_blocks

t1 = os.path.getmtime(name)
x1=datetime.datetime.fromtimestamp(t1)
print x1
t2 = os.path.getatime(name)
x2=datetime.datetime.fromtimestamp(t2)
print x2
t3 = os.path.getmtime(name)
x3=datetime.datetime.fromtimestamp(t3)
print x3

os.close(fd)