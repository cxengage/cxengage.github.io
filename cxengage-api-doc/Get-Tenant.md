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
Authorization: Bearer FehRxgBFGMYQnIdIIrw9rDYpQ3tDNm3OtxVe2qru0mxh
Cache-Control: no-cache
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


