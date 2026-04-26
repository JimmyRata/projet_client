from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import Optional
import logging

logging.basicConfig(level=logging.INFO, format="%(asctime)s - %(levelname)s - %(message)s")
logger = logging.getLogger(__name__)

app = FastAPI(title="CRM", version="1.0.0")

# Stockage en mémoire (simule un CRM/ERP distant)
clients_db: dict[int, dict] = {
    1: {"id": 1, "nom": "Dupont", "prenom": "Jean", "email": "jean.dupont@mail.com", "ville": "Paris"},
    2: {"id": 2, "nom": "Martin", "prenom": "Sophie", "email": "sophie.martin@mail.com", "ville": "Lyon"},
}

class Client(BaseModel):
    id: int
    nom: str
    prenom: str
    email: str
    ville: Optional[str] = None

class ClientUpdate(BaseModel):
    nom: Optional[str] = None
    prenom: Optional[str] = None
    email: Optional[str] = None
    ville: Optional[str] = None

@app.get("/clients", response_model=list[Client])
def get_clients():
    """Retourne tous les clients du système distant."""
    logger.info(f"GET /clients → {len(clients_db)} clients retournés")
    return list(clients_db.values())

@app.get("/clients/{client_id}", response_model=Client)
def get_client(client_id: int):
    if client_id not in clients_db:
        raise HTTPException(status_code=404, detail="Client non trouvé")
    return clients_db[client_id]

@app.post("/clients", response_model=Client, status_code=201)
def create_client(client: Client):
    """Crée un nouveau client."""
    if client.id in clients_db:
        raise HTTPException(status_code=409, detail=f"Client {client.id} existe déjà")
    clients_db[client.id] = client.dict()
    logger.info(f"POST /clients → Créé : {client.nom} {client.prenom}")
    return clients_db[client.id]

@app.put("/clients/{client_id}", response_model=Client)
def update_client(client_id: int, update: ClientUpdate):
    """Met à jour un client existant."""
    if client_id not in clients_db:
        raise HTTPException(status_code=404, detail="Client non trouvé")
    stored = clients_db[client_id]
    updated_fields = update.dict(exclude_none=True)
    stored.update(updated_fields)
    logger.info(f"PUT /clients/{client_id} → Mis à jour : {updated_fields}")
    return stored

@app.get("/health")
def health():
    return {"status": "ok", "clients_count": len(clients_db)}