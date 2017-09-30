import os,sys,time

def child(say):
	time.sleep(1)
	print 'PID of Child:%d',os.getpid()
	string=raw_input("String Taak:	")
	os.write(say,string)

def parent():
	listen,say=os.pipe()
	
	if os.fork()==0:
		child(say)	
	
	while True:
		line=os.read(listen,32)
		print 'PID of Parent:%d',os.getpid()
		rev_string=line[::-1]
		print rev_string
		break

parent()

