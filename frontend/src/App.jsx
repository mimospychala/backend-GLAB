import styles from "./App.module.css"
import { Outlet } from "react-router"
import Header from "./components/Header"
import SideBar from "./components/SideBar"
import sideBarItems from "./lib/data/sideBarItems"



function App() {
  return (
      <>
        <Header />
      <div className={styles.app}>
        <SideBar sideBarItems={sideBarItems} />
        <div className={styles.content}>
          <Outlet />
        </div>
      </div> </>
  )
}

export default App
