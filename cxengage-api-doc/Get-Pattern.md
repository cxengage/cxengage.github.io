#Pattern Resources

```
  GET tenants/:iid/patterns/:id
```

## Description

Retrieves the node for the given instance.



### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Pattern to retrieve

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or pattern does not exist or has been deleted.

### Example

**Request**

```
  GET tenants/tenant1/patterns/PT2
```

**Return**

```json
{
  "id":"PT2",
  "when":"(when (event (= \"id\" \"1234\")))",
  "then":"(seq (send echo message {:message \"Hello world\"}))",
  "status":true,
  "description":"Sample Pattern",
  "name":"Sample Pattern"
}
```

```
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/patterns \
     -H 'Authorization: Bearer {{token}}'
```

