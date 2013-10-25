# Augment Resources

```
  POST tenants/:iid/augments
```

## Description

Create an Augment for a tenant

### Parameters

- **iid** _(required)_ — Selected tenants

### Errors

All known errors will be returned in a JSON map with key "error".



**Request**

```
  POST tenants/tenant1/augments
  Content-Type: application/json; charset=utf-8
```

```json
{
    "service": "engine",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "api",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}
```


**Return**

```json
{
    "service": "engine",
    "id": "AU2",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "api",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}


### curl Example

```
curl -X POST http://api.cxengage.com/tenants/{{tenant-name}}/augment \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"service": "engine", "id": "AU2", "name": "rest augment api", "description": "describe", "augment-service": "engine", "type": "api", "options": { "url": "hostname", "attributes": ["customerSegment"]}}'
```

### File based augment

**Request**

```
  POST tenants/tenant1/augments
  Content-Type: application/json; charset=utf-8
```

```json
{
    "service": "engine",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "file",
    "options": {
        "attributes": [
            "customerSegment", "twitter"
        ]
    }
}
```


**Return**

```json
{
    "service": "engine",
    "id": "AU2",
    "name": "rest augment api",
    "description": "description",
    "augment-service": "engine",
    "type": "file",
    "options": {
        "url": "hostname",
        "attributes": [
            "customerSegment"
        ]
    }
}


### curl Example

```
curl -X POST http://api.cxengage.com/tenants/{{tenant-name}}/augment \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"service": "engine","id": "AU2","name": "rest augment api", "description": "","augment-service": "engine","type": "file","options": {"attributes": ["customerSegment", "twitter"]}}'
```
