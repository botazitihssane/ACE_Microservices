import React, { useState, useEffect } from "react";
import { BiPencil } from "react-icons/bi";
import "bootstrap/dist/css/bootstrap.min.css";
import Layoutprop from "./Layoutprop";
import Footer from "../visiteur/Footer";

const HomePage = () => {
  const [userInfo, setUserInfo] = useState({
    id: "",
    username: "",
    photo: "",
    email: "",
    password: "",
    biographie: "",
  });

  const [editingField, setEditingField] = useState(null);

  const handleUpdate = (field, value) => {
    setUserInfo({ ...userInfo, [field]: value });
    setEditingField(null);
    updateUserInfoOnServer({ [field]: value });
  };

  const updateUserInfoOnServer = (updatedData) => {
    fetch("http://localhost:8088/blog/proprietaire", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedData),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => {
        console.log("User information updated on the server:", data);
      })
      .catch((error) => {
        console.error("Error updating user information:", error);
      });
  };

  const loadProprietaire = (id) => {
    console.log(userInfo.id);
    fetch(`http://localhost:8088/blog/proprietaire/id/${id}`)
      .then((response) => response.json())
      .then((data) => {
        setUserInfo((prevUserInfo) => ({
          ...prevUserInfo,
          photo: data.photo,
          biographie: data.biographie,
          email: data.email,
          password: data.password,
        }));
        console.log(data);
      });
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];

    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setUserInfo({ ...userInfo, photo: reader.result });
      };
      reader.readAsDataURL(file);
    }
  };

  useEffect(() => {
    const loadUserFromLocalStorage = () => {
      const userFromLocalStorage = JSON.parse(localStorage.getItem("user"));
      console.log("userFromLocalStorage:", userFromLocalStorage);
      if (userFromLocalStorage) {
        setUserInfo({
          id: userFromLocalStorage.id,
          username: userFromLocalStorage.username,
          biographie: userFromLocalStorage.biographie,
          email: userFromLocalStorage.email,
          photo: userFromLocalStorage.photo,
        });
      }
      loadProprietaire(userFromLocalStorage.id);
    };

    loadUserFromLocalStorage();
  }, []);

  const renderField = (field, label) => {
    return (
      <div className="mb-3">
        <label htmlFor={field} className="form-label">
          {label}
        </label>
        <div className="d-flex">
          {field === "photo" ? (
            <img
              src={userInfo[field]}
              alt="Profile"
              className="img-thumbnail me-3"
              style={{ maxWidth: "100px", maxHeight: "100px" }}
            />
          ) : (
            <div className="me-3">{userInfo[field]}</div>
          )}
          <button
            className="btn btn-warning"
            onClick={() => setEditingField(field)}
          >
            <BiPencil /> Edit
          </button>
        </div>
        {editingField === field && (
          <div className="mt-2">
            {field === "photo" ? (
              <input
                type="file"
                id={field}
                className="form-control"
                accept="image/*"
                onChange={handleImageChange}
              />
            ) : (
              <input
                type="text"
                id={field}
                className="form-control"
                value={userInfo[field]}
                onChange={(e) =>
                  setUserInfo({ ...userInfo, [field]: e.target.value })
                }
              />
            )}
            <div className="mt-2">
              <button
                className="btn btn-primary"
                onClick={() => handleUpdate(field, userInfo[field])}
              >
                Update
              </button>
              <button
                className="btn btn-secondary ms-2"
                onClick={() => setEditingField(null)}
              >
                Cancel
              </button>
            </div>
          </div>
        )}
      </div>
    );
  };

  return (
    <>
      <Layoutprop />
      <div className="container mt-5">
        <h2
          style={{
            fontFamily: "'Libre Franklin', sans-serif",
            fontWeight: 900,
            textAlign: "center",
          }}
        >
          Hello To your blog
        </h2>

        <p
          style={{ fontFamily: "Dancing Script, cursive", textAlign: "center" }}
        >
          here you can share your ideas
        </p>

        <div className="card">
          <div className="card-body">
            {renderField("username", "Username")}
            {renderField("photo", "Photo")}
            {renderField("biographie", "Biography")}
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default HomePage;
