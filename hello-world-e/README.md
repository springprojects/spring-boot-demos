
C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/"
{
  "_links" : {
    "people" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/alps"
    }
  }
}
C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/alps"
{
  "version" : "1.0",
  "descriptors" : [ {
    "href" : "http://192.168.1.99:8077/hello-world-e/alps/people",
    "name" : "people"
  } ]
}
C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/people"
{
  "_links" : {
    "self" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search"
    }
  },
  "_embedded" : {
    "people" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/1"
        }
      }
    } ]
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/people/1"
{
  "firstName" : "Frodo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/1"
    }
  }
}

C:\Users\Administrator
λ curl -i -X POST -H "Content-Type:application/json" -d "{\"firstName\":\"Frodoa\",\"lastName\":\"Bagginsa\"
}" "http://192.168.1.99:8077/hello-world-e/people"
HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://192.168.1.99:8077/hello-world-e/people/3
Content-Length: 0
Date: Fri, 03 Apr 2015 04:05:35 GMT


C:\Users\Administrator
λ curl -i -X POST -H "Content-Type:application/json" -d "{\"firstName\":\"Frodoa\",\"lastName\":\"Bagginsa\"
}" "http://192.168.1.99:8077/hello-world-e/people" -v
* About to connect() to 192.168.1.99 port 8077 (#0)
*   Trying 192.168.1.99...
* Adding handle: conn: 0x23e5a00
* Adding handle: send: 0
* Adding handle: recv: 0
* Curl_addHandleToPipeline: length: 1
* - Conn 0 (0x23e5a00) send_pipe: 1, recv_pipe: 0
* Connected to 192.168.1.99 (192.168.1.99) port 8077 (#0)
> POST /hello-world-e/people HTTP/1.1
> User-Agent: curl/7.30.0
> Host: 192.168.1.99:8077
> Accept: */*
> Content-Type:application/json
> Content-Length: 44
>
* upload completely sent off: 44 out of 44 bytes
< HTTP/1.1 201 Created
HTTP/1.1 201 Created
* Server Apache-Coyote/1.1 is not blacklisted
< Server: Apache-Coyote/1.1
Server: Apache-Coyote/1.1
< Location: http://192.168.1.99:8077/hello-world-e/people/4
Location: http://192.168.1.99:8077/hello-world-e/people/4
< Content-Length: 0
Content-Length: 0
< Date: Fri, 03 Apr 2015 04:05:48 GMT
Date: Fri, 03 Apr 2015 04:05:48 GMT

<
* Connection #0 to host 192.168.1.99 left intact

C:\Users\Administrator
λ ccurl "http://192.168.1.99:8077/hello-world-e/"
{
  "_links" : {
    "people" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/alps"
    }
  }
}
C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/people"
{
  "_links" : {
    "self" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search"
    }
  },
  "_embedded" : {
    "people" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/1"
        }
      }
    }, {
      "firstName" : "Frodoa",
      "lastName" : "Bagginsa",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/2"
        }
      }
    }, {
      "firstName" : "Frodoa",
      "lastName" : "Bagginsa",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/3"
        }
      }
    }, {
      "firstName" : "Frodoa",
      "lastName" : "Bagginsa",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/4"
        }
      }
    } ]
  },
  "page" : {
    "size" : 20,
    "totalElements" : 4,
    "totalPages" : 1,
    "number" : 0
  }
}
C:\Users\Administrator
λ

C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/people/search"
{
  "_links" : {
    "findByFirstNameAndLastName" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/findByFirstNameAndLastName{?firstName,lastName}",
      "templated" : true
    },
    "findByLastName" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/findByLastName{?name}",
      "templated" : true
    },
    "findByFirstName" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/findByFirstName{?name}",
      "templated" : true
    },
    "findByFirstNameLike" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/findByFirstNameLike{?name}",
      "templated" : true
    },
    "querySql" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/querySql{?firstName}",
      "templated" : true
    },
    "querySql2" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/search/querySql2{?firstName,lastName}",
      "templated" : true
    }
  }
}

C:\Users\Administrator
λ curl "http://192.168.1.99:8077/hello-world-e/people/search/findByLastName?name=Baggins"
{
  "_embedded" : {
    "people" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://192.168.1.99:8077/hello-world-e/people/1"
        }
      }
    } ]
  }
}

C:\Users\Administrator
λ curl -X PUT -H "Content-Type:application/json" -d "{\"firstName\":\"Bilbo\",\"lastName\":\"Baggins\"}" "ht
tp://192.168.1.99:8077/hello-world-e/people/1"

C:\Users\Administrator
λ curl -"http://192.168.1.99:8077/hello-world-e/people/1"  \
{
  "firstName" : "Bilbo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://192.168.1.99:8077/hello-world-e/people/1"
    }
  }
}


curl -i -X POST -H "Content-Type:application/json" -d "{\"title\":\"soso\",\"text\":\"8888888888999999ddd\",\"tags\":\"test,hello\"}" "http://192.168.1.99:8077/hello-world-e/notes" -v

curl -i -X POST -H "Content-Type:application/json" -d "{\"firstname\":\"firstname1\",\"lastname\":\"lastname2\",\"gender\":\"MALE\",\"address\":{\"street\":\"streetaa\",\"zipCode\":\"333\",\"city\":\"ocl\",\"state\":\"state22\"}}" "http://192.168.1.99:8077/hello-world-e/customers" -v



