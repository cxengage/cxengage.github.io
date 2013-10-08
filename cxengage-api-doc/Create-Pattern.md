# Pattern Resources

```
  POST tenants/:iid/patterns
```

## Description

Creates a pattern on the given tenants.


### Parameters

- **iid** _(required)_ — Selected tenants

### Errors

All known errors will be returned in a JSON map with key "error".



**Request**

```
  POST tenants/tenant1/patterns
  Content-Type: application/json
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
