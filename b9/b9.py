import bottle
import pymongo
import gridfs
from bottle import *
from pymongo import MongoClient

connect_object =pymongo.MongoClient()
db = connect_object.dhananjay
articles =db.articles
fs = gridfs.GridFS(db)

filename ="flower.png"
datafile = open(filename,"r")
thedata = datafile.read()

stored=fs.put(thedata,filename="testimage.png")

yoname="testimage.png"

@bottle.route('/')
def index():
	response.headers['content-Type'] = 'text/html; charset=UTF-8'
	return bottle.template('b9')
	
@route('/text/')
def test():
	club="This is Sparta!!"
	articles.save({"article":club})
	total_articles = articles.find()
	for record in total_articles:
		sample=record['article']
		
		response.content_type='text/css'
		return sample
	
@route('/images/')
def image():
	gridout = fs.get_last_version(filename=yoname)
	response.content_type = 'image/png'
	return gridout
	
bottle.run(host='localhost',port=8080)
