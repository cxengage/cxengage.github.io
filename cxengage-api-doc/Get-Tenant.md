# Tenant Resources

```
  GET /tenants/:tid
```

## Description

Retrieves tenant info

## Parameters

- **iid** _(required)_ — Selected tenant


### Errors

All known errors will be returned in a JSON map with key "error".

### Example

**Request**

```
GET /1.0/tenants/{{tenant}} HTTP/1.1
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

```
curl -X GET https://api.cxengage.net/1.0/tenants/{{tenant-name}} \
     -H 'Authorization: Bearer {{token}}'
```


