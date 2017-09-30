import os,socket,time

class Client:
	def __init__(self):
		self.c=socket.socket()
		self.port=12111
		self.data=""
		
	def connectServer(self):
		print "Connecting..."
		self.c.connect(('',self.port))
		time.sleep(3)
		print "Connected!!!"
		
	def read(self):
		self.data=self.c.recv(1024)
		print "File Received from Server..."
		print ("Server File was:\n"+self.data)
		print "Copying it to new..."
		self.fd1=open("new","wr")
		self.fd1.write(self.data)
		self.fd1.close()
		
	def write(self):
		data1=raw_input("Enter text to append into server file:")
		self.c.send(data1)
		self.c.close()
		
	def closeConnection(self):
		self.c.close()
		
if __name__ == "__main__":
	o2=Client()
	o2.connectServer()
	o2.read()
	o2.write()
