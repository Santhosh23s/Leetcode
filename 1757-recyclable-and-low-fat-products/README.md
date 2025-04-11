<h2><a href="https://leetcode.com/problems/recyclable-and-low-fat-products/?envType=problem-list-v2&envId=database">1757. Recyclable and Low Fat Products</a></h2><h3>Easy</h3><hr><p>Table: <code>Products</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| low_fats    | enum    |
| recyclable  | enum    |
+-------------+---------+
product_id is the primary key (column with unique values) for this table.
low_fats is an ENUM (category) of type (&#39;Y&#39;, &#39;N&#39;) where &#39;Y&#39; means this product is low fat and &#39;N&#39; means it is not.
recyclable is an ENUM (category) of types (&#39;Y&#39;, &#39;N&#39;) where &#39;Y&#39; means this product is recyclable and &#39;N&#39; means it is not.</pre>

<p>&nbsp;</p>

<p>Write a solution to find the ids of products that are both low fat and recyclable.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Products table:
+-------------+----------+------------+
| product_id  | low_fats | recyclable |
+-------------+----------+------------+
| 0           | Y        | N          |
| 1           | Y        | Y          |
| 2           | N        | Y          |
| 3           | Y        | Y          |
| 4           | N        | N          |
+-------------+----------+------------+
<strong>Output:</strong> 
+-------------+
| product_id  |
+-------------+
| 1           |
| 3           |
+-------------+
<strong>Explanation:</strong> Only products 1 and 3 are both low fat and recyclable.
</pre>

---

# Notes📝

---

## ✅ 1. **SQL Notes for the Query**

### 📌 **Query:**
```sql
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';
```

---

### 🧠 **Explanation:**

| Clause         | Purpose                                                 |
|----------------|----------------------------------------------------------|
| `SELECT`       | Chooses which column(s) to return — here, `product_id`  |
| `FROM Products`| From the table named `Products`                         |
| `WHERE`        | Filters rows where both conditions are true             |
| `low_fats='Y'` | Checks if the product is low in fat                     |
| `recyclable='Y'` | Checks if the product is recyclable                   |
| `AND`          | Both conditions must be true                            |

---

### 🔍 Use Case:

This query is useful when you want to **list all products that are both low fat and recyclable** — e.g., for eco-friendly and health-focused filtering in an app or report.

---

### ✅ Output Example:

| product_id |
|------------|
| 1        |
| 3        |

---
