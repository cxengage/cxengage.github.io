# Tenant Resources


## Description

Retrieves tenant info



### Errors

- **422 Unprocessable Entity** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}} HTTP/1.1
Host: api.cxengage.net
Authorization: Bearer {{token}}
```

**Return**

```json

{
    "id": "tenant1",
    "name": "Tenant Number One"
}

```

### curl Example

```bash
curl -X GET https://api.cxengage.net/1.0/tenants/{{tenant-name}} \
     -H 'Authorization: Bearer {{token}}'
```


