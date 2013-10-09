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
  GET tenants/tenant1/patterns
```

**Return**

```json

  {
   "id": "PT10",
   "then": "(par (send echo message {:message \"We should probably call the customer\"}) (send echo message {:message \"We should probably call the customer now now now now\"}))",
   "when": "(within 1 minutes (allOf (count 4 (event (and (= customerSegment \"Gold\") (= eventType \"flcheck\")))) (event (and (= customerSegment \"Gold\") (= eventType \"cnclTicket\"))))))",
   "description": "Loyalty Pattern for Gold customers",
   "name": "Loyalty Pattern"
  }


```
