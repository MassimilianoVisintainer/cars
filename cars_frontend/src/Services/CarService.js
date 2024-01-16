import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/car";

export const listCars = () => {
    return axios.get(REST_API_BASE_URL);
} 

export const deleteCar = (id) => {
    return axios.delete(`${REST_API_BASE_URL}/${id}`)
}

export const addCar = (carAdded) => {
    return axios.post(REST_API_BASE_URL, carAdded);
}