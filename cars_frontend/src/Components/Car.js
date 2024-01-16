import React from 'react'
import { useEffect,useState } from 'react'
import { listCars, deleteCar } from '../Services/CarService';
import {useNavigate} from  "react-router-dom";

function Car() {

    const [cars, setCars] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        listCars().then((response) => {
            setCars(response.data);
                }).catch(error => {
                    console.error(error);
                })
        
                console.log(cars);    }, []);

    function removeCar(id) {
         deleteCar(id).then((response) => {
            console.log(`Car deleted with id ${id}`)
         }).catch(error => {
            console.error(error);
         })     
    }

    function addCar() {
        navigator("/addCar");
    }

  return (
    <div>
        <h1 className="text-center">Cars</h1>
        <br></br>
        <button type="button" className="btn btn-dark" onClick={() => addCar()}>Add</button>
        <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Car Id</th>
                        <th>Model</th>
                        <th>Year</th>
                        <th>Brand</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                {
                    cars.map( car => 
                        <tr key={car.id}>
                            <td>{car.id}</td>
                            <td>{car.model}</td>
                            <td>{car.year}</td>
                            <td>{car.brand}</td>
                            <td>
                            <button type="button" className="btn btn-dark"  onClick={() => removeCar(car.id)}>Delete</button>
                            </td>
                        </tr>
                    )
                }
                </tbody>
                </table>
    </div>
  )
}

export default Car