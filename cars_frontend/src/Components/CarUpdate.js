import { useEffect, useState } from "react"
import { getCarById, updateCar } from "../Services/CarService";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function CarUpdate() {

    const [brand, setBrand] = useState("");
    const [model, setModel] = useState("");
    const [year, setYear] = useState("");

    const navigator = useNavigate();

    const {id} = useParams();

    useEffect(() => {

        getCarById(id).then((response) => {

            setBrand(response.data.brand);
            setModel(response.data.model);
            setYear(parseInt(response.data.year));

        }).catch((error) => {
            console.log(error);
        })

    }, [id]);

    function update(id) {
        const carUpdated = {brand, model, year};

        updateCar(id, carUpdated).then((response) => {
            navigator("/");
            return response.data
        }).catch((error) => {
            console.log(error);
        })
    }
 
    return (
        <div className="container">
        <br></br>
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3 ">
            <h1 className="text-center">Cars</h1>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label"> Brand</label>
                  <input
                    type="text"
                    placeholder="Enter Car Brand"
                    name="carBrand"
                    value={brand}
                    className="form-control"
                    onChange={(e) => setBrand(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Model</label>
                  <input
                    type="text"
                    placeholder="Enter Car Model"
                    name="model"
                    value={model}
                    className="form-control"
                    onChange={(e) => setModel(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Year</label>
                  <input
                    type="text"
                    placeholder="Enter Car Year"
                    name="carYear"
                    value={year}
                    className="form-control"
                    onChange={(e) => setYear(parseInt(e.target.value))}
                  ></input>
                </div>
                <button type="button" className="btn btn-dark" onClick={() => update(id)} >
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
  )
}

export default CarUpdate