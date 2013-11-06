## Integration Resources


## Description

Retrieves integrations for the given tenant.



### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant/integration does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/integrations HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
[
  {
    "id": "datasift",
    "api-key": "keyvalue",
    "username": "usernamevalue"
}

    {
        "id": "echo"
    }
]
```

### curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/integrations \
     -H 'Authorization: Bearer {{token}}'
```

