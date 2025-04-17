import styles from "./App.module.css"
import { Outlet } from "react-router"
import Header from "./components/Header"
import SideBar from "./components/SideBar"
import sideBarItems from "./lib/data/sideBarItems"
import ShoppingCartButton from "./components/ShoppingCartButton"



function App() {
  return (
    <>
      <Header />
      <SideBar sideBarItems={sideBarItems} />
      <div className={styles.sidebarDiv}></div>
      <ShoppingCartButton/>

      <div className={styles.headerDiv}/>
      <div className={styles.app}>
        <div className={styles.content}>
          <Outlet />
        </div>
      </div> </>
  )
}

export default App
