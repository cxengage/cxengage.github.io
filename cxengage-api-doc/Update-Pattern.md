# Pattern Resources

```
  POST tenants/:iid/patterns/:id
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
  POST tenants/tenant1/patterns/PT1
```

```json
{
 "id":"PT1",
 "then":"(seq (send echo message {:message \"Hello world\"}))",
 "when":"(when (event (= \"id\" \"1234\")))",
 "status":true,
 "description":"Updated Sample Pattern",
 "name":"Sample Pattern"}
```

**Return**

```json

{
  "id":"PT1",
  "then":"(seq (send echo message {:message \"Hello world\"}))",
  "when":"(when (event (= \"id\" \"1234\")))",
  "status":true,
  "description":"Updated Sample Pattern",
  "name":"Sample Pattern"
}
```

### curl Example
```
curl -X POST https://api.cxengage.net/tenants/{{tenant-name}}/patterns/PT5 \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then":"(send echo message {:message \"Updated pattern 5\"})","when":"(event (= type \"curl\"))","status":true,"name":"Updated curl Pattern"}'
```

