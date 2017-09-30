import os,thread,threading,socket,time

class Server:
	def __init__(self):
		self.s=socket.socket()
		self.port=12111
		self.data=""
		self.filelock=threading.Lock()
		
	def startServer(self):
		print"\n Server started"
		self.s.bind(('',self.port))
		print"\n Server Binded with port"
		self.s.listen(5)
		print"\n Server waiting for clients"
		
	def clients(self,data1,addr):
		self.filelock.acquire()
		print "Lock Acquired"
		self.fd1=open("text","a")
		self.fd1.write(data1)
		self.fd1.close()
		self.filelock.release()
		print "Lock Release"
		
	def connections(self):
		while True:
			obj,addr=self.s.accept()
			print "connection established with->",addr
			self.fd2=open("text","r")
			self.data=self.fd2.read()
			self.fd2.close()
			
			print "Sending data to client..."
			obj.send(self.data)
			time.sleep(3)
			
			data1=obj.recv(1024)
			
			try:
				thread.start_new_thread(self.clients,(data1,addr))
			except:
				print "failed to create thread!!"
				
		self.s.close()

	def closeConnection():
		self.s.close()

if __name__ == "__main__":
	o=Server()
	o.startServer()
	o.connections()
	o.closeConnection()
