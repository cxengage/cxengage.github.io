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
{ "url" : "http://hostname/augment", "type" : "engine", "attributes" : ["customerSegment"]}
```


**Return**

```json
{
    "id": "AU4",
    "url": "http://hostname/augment",
    "type": "engine",
    "attributes": [
        "customerSegment"
    ]
}
```

```
curl -X POST http://api.cxengage.com/tenants/{{tenant-name}}/augment \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{ "url" : "http://hostname/augment", "type" : "engine", "attributes" : ["customerSegment"]}'
 ```

