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
  GET /tenants/tenant1
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
curl -X GET http://192.168.0.28:8182/tenants/tenant1 \
     -H 'Authorization: Bearer {{token}}'
```


