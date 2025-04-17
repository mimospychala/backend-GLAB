import { atom, useAtom } from "jotai"
import { useEffect } from "react"

const productsInStorage = localStorage.getItem("cart")



const productsAtom = atom(productsInStorage ? JSON.parse(productsInStorage) : [])

export function useShoppingCart() {
    const [products, setProducts] = useAtom(productsAtom)

    useEffect(() => {
        const productsInStorage = localStorage.getItem("cart")
        if(productsInStorage) {
            const storedProducts = JSON.parse(productsInStorage)
            setProducts(storedProducts)
        }
    }, [])


    useEffect(() => {
        localStorage.setItem("shoppingcart", JSON.stringify(products))
    }, [products])
    


    const addProduct = (product) => {
        setProducts(prevProducts => {
            const existingProduct = prevProducts.find(p => p.id === product.id)

            if (existingProduct) {
                return prevProducts.map(p => {
                    if (p.id === product.id) {
                        p.count += 1
                        return p
                    } else {
                        return p
                    }
                })

            } else {
                const newProducts = [
                    ...prevProducts,
                    { ...product, count: 1 }
                ]
                return newProducts
            }
        })

    }

    const removeProduct = (product) => {
        setProducts(prevProducts => {
            const existingProduct = prevProducts.find(p => p.id === product.id)

            if (existingProduct) {
                if (existingProduct.count === 1) {
                    return prevProducts.filter(p => p.id !== product.id)
                } else {
                    return prevProducts.map(p => {
                        if (p.id === product.id) {
                            p.count -= 1
                            return p
                        } else {
                            return p
                        }
                    })
                }
            }

            return prevProducts
        })

    }

    return [products, addProduct, removeProduct]
}