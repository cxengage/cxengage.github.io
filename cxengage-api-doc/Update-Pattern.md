# Pattern Resources


## Description

Updates the pattern for the given tenant based on the pattern id given

### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant or pattern does not exist or has been deleted.


### Example

**Request**

```http
PUT /1.0/tenants/{{tenant-name}}/patterns/PT5 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache

```

```json
{
"then" : "(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})"
}
```

**Return**

```json

{"id":"PT5",
"then":"(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})",
"when":"(event (or (= username \"cxengage\")))",
"status":true,
"name":"Updated Pattern"
}    
```

### curl Example
```bash
curl -X PUT https://api.cxengage.net/1.0/tenants/userevents/patterns/PT5 \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then" : "(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})"}'

```

