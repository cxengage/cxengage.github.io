Generic Streaming Endpoint
========

An easy way to integrate generic external services into CxEngage is by using the generic streaming
endpoint (GSE). This endpoint allows the sending of any text data to all connected users by way of websockets.

### Sends

The GSE supports a single send **message** which accepts a single parameter of **body**

```clojure
(seq (send generic message {:body "Hello world"}))
```

Any connected web sockets for your tenant would receive the message *"Hello world"* upon executing the above
reaction.

Templating allows you to send more complicated formats, for example you could make a template which formats JSON:

```mustache
{"id" : "{{id}}"
 {{#name}}
 ,"name" : "{{name}}"
 {{/name}}}
```

The above template would create a JSON object which would extract the *id* field from the reaction context, and
if present in the context, add in the *name* field to the object.

Sending this message would be done as follows:

```clojure
(seq (send generic message {} (template {:body +TM1})))
```

Where **+TM1** refers to the above template.

### Connecting

To open a web socket to the GSE one must first obtain their oauth bearer token, and request a stream ticket.
Refer to the auth section for instructions on acquiring your oauth token.

A stream ticket can be acquired using the following request:

```http
POST /1.0/tenants/<tenantid>/ticket HTTP/1.1
Host: stream.cxengage.net
Authorization: Bearer <token>
```

Which results in the following response:

```json
{
    "ticket": "3eefbc28-ed3a-4c69-873d-8000bcd02f46"
}
```

The ticket provided is valid for a single use within 2 minutes of requesting and must be used by the same IP address which requested the ticket.

The ticket can then be used to open a web socket at the following address:

```
ws://stream.cxengage.net/1.0/stream/<ticket>
```

Sending data is not permitted on the socket, only receiving data.
The socket will be sent all notifications sent to in while connected. It is important to note
that if no sockets are connected when a notification is sent, the message will be discarded and
the notification will be counted as a success.
