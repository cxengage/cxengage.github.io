# Pattern Resources


## Description

Creates a pattern on the given tenants.


### Mandatory Parameters


- **name** — Name of Pattern

### Optional Parameters

- **description** — Description of pattern
- **status** — Enabled or Disable pattern
- **when** — When portion of pattern
- **then** — Then portion of pattern


### Errors

All known errors will be returned in a JSON map with key "error".


**Request**

```http
POST /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{ 
  "name": "Sample Pattern",
  "description": "Sample",
  "status":true,
  "when": "(when (event (= \"id\" \"1234\")))",
  "then": "(seq (send echo message {:message \"Hello world\"}))"
}
```

**Return**

```json
{ 
  "id": "PT2",
  "name": "Sample Pattern",
  "description": "Sample",
  "status":true,
  "when": "(when (event (= \"id\" \"1234\")))",
  "then": "(seq (send echo message {:message \"Hello world\"}))"
}
```

### curl Example

```
curl -X POST https://api.cxengage.net/1.0/tenants/{{tenant-name}}/patterns \
 -H 'Authorization: Bearer {{token}}' \
 -H 'Content-Type: application/json; charset=utf-8' \
 -d '{"then":"(send echo message {:message \"Hello curl\"})","when":"(event (= type \"curl\"))","status":true,"name":"curl Pattern"}'
 ```

