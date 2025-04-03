import styles from "./App.module.css"
import { Outlet } from "react-router"
import Header from "./components/Header"



function App() {
  return (
      <>
        <Header />
        <main className={styles.app}>
          <Outlet/>
        </main>
      </>
  )
}

export default App
