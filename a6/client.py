#!/usr/bin/python           

import socket               # Import socket module
print "Client Side Program"
s = socket.socket()         # Create a socket object
host = raw_input("Enter ip for server:\t") # Get local machine name
port = 40003              # Reserve a port for your service.
s.connect((host, port))
s.send(raw_input("Enter the file path:\t"))
print s.recv(1024)
print s.recv(2048)
s.close                     # Close the socket when done
'''
Client Side Output
[te@dbsl2 asignment 6]$ python client.py
Client Side Program
Enter ip for server:	127.0.0.1
Enter the file path:	/home/te/test
Begining to send file contents
This is the content of test file.
Thankyou for connecting

'''
