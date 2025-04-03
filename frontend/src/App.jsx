import styles from "./App.module.css"
import { Outlet } from "react-router"

function App() {
  return (
      <>
        <main className={styles.app}>
          <Outlet/>
        </main>
      </>
  )
}

export default App
