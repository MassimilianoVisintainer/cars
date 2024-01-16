import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Car from './Components/Car';
import 'bootstrap/dist/css/bootstrap.css';
import CarForm from './Components/CarForm';
import CarUpdate from './Components/CarUpdate';

function App() {
  return (
    <BrowserRouter>
    <Routes>
    <Route path='/' element={<Car/>}/>
    <Route path='/addCar' element={<CarForm/>}/>
    <Route path='/updateCar/:id' element={<CarUpdate/>}/>
    </Routes>
    </BrowserRouter>
    
  );
}

export default App;