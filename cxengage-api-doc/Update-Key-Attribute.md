## Key Attribute Resources



## Description

Updates key attribute for the given tenant.



### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant does not exist or has been deleted.

### Content Type

```
Content-Type: application/json; charset=utf-8
```

### Example

**Request**

```
POST /tenants/{{tenant-name}}/key-attribute HTTP/1.1
Host: {{cxenage-api}}
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
```

```json
{
    "key": "username"
}
```
 
### curl Example

```
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/key-attribute \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"key" : "username"}' 
```

