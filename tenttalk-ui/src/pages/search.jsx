import Navbar from "../components/navbar";
import ResultTable from "../components/search/ResultTable";

export function Search() {
    return(
    <div>
        <Navbar />
        <h1>Search Page</h1>
        <ResultTable />
    </div>
    );
}