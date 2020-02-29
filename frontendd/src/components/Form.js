import React, {Component} from 'react';

class Form extends Component{

    constructor(props) {
        super(props);
        this.state ={
          list:[]
        }
      }    

      async componentDidMount(){
        try {
            let misCabeceras = new Headers({
              'Content-Type': 'application/json'
            });

            let miInit = { method: 'GET',
                          headers: misCabeceras,
                          mode: 'cors',
                          cache: 'default' };

            let res = await fetch('http://127.0.0.1:8086/registros',miInit);
            let data = await res.json();  
            console.log("datsoo", data);            
            this.setState({
              list: data
            });
        } catch (error) {
            this.setState({
                error
            });
        }
      }    
      render() {               
        return (
          <div>            
            <h1>Listado</h1>             
            <table>
              <tr>
                <th>Documento</th>
                <th>Fecha</th>
              </tr>
              <tbody>
              {this.state.list.map((registro) => (    
                <tr key={registro.id}>
                  <td>{registro.documento}</td>
                  <td>{new Date(registro.fecha).toDateString("YYYY-mm-dd")}</td>
                </tr>                            
              ))}
              </tbody> 
            </table>            
          </div>
       )
      }    
}
export default Form;