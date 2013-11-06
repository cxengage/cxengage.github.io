# Pattern Resources

```
  PUT tenants/:iid/patterns/:id
```

## Description

Updates the pattern for the given tenant based on the pattern id given


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Pattern id

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or pattern does not exist or has been deleted.

### Content Type

```
Content-Type: application/json; charset=utf-8
```

### Example

**Request**

```
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
```
curl -X PUT https://api.cxengage.net/1.0/tenants/userevents/patterns/PT5 \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then" : "(send sendgrid email {:to *email*, :subject \"Welcome to a wonderful put experience\"})"}'

```

