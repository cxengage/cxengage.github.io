# Pattern Resources

```
  GET tenants/:iid/patterns
```

## Description

Retrieves all patterns on tenant :iid


### Parameters

- **iid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".


### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

**Return**

```json

  {
   "id": "PT1",
   "then": "(par (send echo message {:message \"We should probably call the customer\"}) (send echo message {:message \"We should probably call the customer now now now now\"}))",
   "when": "(within 1 minutes (allOf (count 4 (event (and (= customerSegment \"Gold\") (= eventType \"flcheck\")))) (event (and (= customerSegment \"Gold\") (= eventType \"cnclTicket\"))))))",
   "description": "Loyalty Pattern for Gold customers",
   "name": "Loyalty Pattern"
  }


```
