import { useState } from "react";

export default function Orders() {
  const [productName, setProductName] = useState("");
  const [quantity, setQuantity] = useState(1);
  const [price, setPrice] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // 这里未来会调用后端 API
    // axios.post("/orders", { productName, quantity, price })

    setMessage(`订单已创建：${productName} x ${quantity}，总价 $${price}`);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Create Order</h2>

      <form
        onSubmit={handleSubmit}
        style={{
          display: "flex",
          flexDirection: "column",
          gap: "12px",
          maxWidth: "300px",
        }}
      >
        <label>
          Product Name:
          <input
            type="text"
            value={productName}
            onChange={(e) => setProductName(e.target.value)}
            required
          />
        </label>

        <label>
          Quantity:
          <input
            type="number"
            min="1"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            required
          />
        </label>

        <label>
          Price:
          <input
            type="number"
            min="0"
            step="0.01"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            required
          />
        </label>

        <button type="submit" style={{ padding: "8px", cursor: "pointer" }}>
          Create Order
        </button>
      </form>

      {message && (
        <p style={{ marginTop: "20px", color: "green", fontWeight: "bold" }}>
          {message}
        </p>
      )}
    </div>
  );
}
