#!/usr/bin/python          

import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 40003            # Reserve a port for your service.
s.bind(('127.0.0.1', port))        # Bind to the port

s.listen(5)                 # Now wait for client connection.
while True:
   c, addr = s.accept()     # Establish connection with client.
   print 'Got connection from', addr
   print 'Client requesting file:\t'
   filename=c.recv(1024)
   print filename
   fd=open(filename,"r")
   data=fd.read()
   fd.close()
   c.send("Begining to send file contents\n"+data+"Thankyou for connecting")
   c.close()                # Close the connection

'''
Server Side Output
[te@dbsl2 asignment 6]$ python server.py
Got connection from ('127.0.0.1', 54553)
Client requesting file:	
/home/te/tes
'''
