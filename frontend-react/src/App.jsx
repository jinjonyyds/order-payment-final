import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import Orders from "./pages/Orders";
import Payments from "./pages/Payments";
import Dashboard from "./pages/Dashboard";

function App() {
  return (
    <BrowserRouter>
      <nav style={{ display: "flex", gap: "20px", padding: "10px" }}>
        <Link to="/">Home</Link>
        <Link to="/orders">Orders</Link>
        <Link to="/payments">Payments</Link>
        <Link to="/dashboard">Dashboard</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/payments" element={<Payments />} />
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
