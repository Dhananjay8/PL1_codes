import os,sys

if os.path.exists('/sys/firmware/efi'):
	print "UEFI Boot"
else:
	print 'Legacy Boot'
